/*
 * Copyright (c) 2016, Salesforce.com, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *    Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *    following disclaimer.
 *
 *    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
 *    the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *    Neither the name of Salesforce.com, Inc. nor the names of its contributors may be used to endorse or
 *    promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.desk.java.apiclient.service;

import com.desk.java.apiclient.model.ApiResponse;
import com.desk.java.apiclient.model.Embed;
import com.desk.java.apiclient.model.FeatureCheck;
import com.desk.java.apiclient.model.Fields;
import com.desk.java.apiclient.model.IOpportunityActivity;
import com.desk.java.apiclient.model.Opportunity;
import com.desk.java.apiclient.model.OpportunityAttachment;
import com.desk.java.apiclient.model.OpportunityTimeline;
import com.desk.java.apiclient.model.SortDirection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * <p>
 *     Service to interact with Desk Opportunities endpoint.
 * </p>
 *
 * Created by Matt Kranzler on 12/28/15.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public interface OpportunityService {

    String FILTERS_URI = "opportunity_filters";
    String OPPORTUNITIES_URI = "opportunities";
    String HISTORY_URI = "history";
    String ACTIVITIES_URI = "activities";
    String SEARCH_URI = "search";
    String ATTACHMENTS_URI = "attachments";

    String SORT_FIELD_UPDATED_AT = "updated_at";

    // Embeds
    String EMBED_OPPORTUNITY_STAGE = "opportunity_stage";
    String EMBED_CUSTOMER = "customer";

    /**
     * Checks to see if opportunities are enabled for the site.
     *
     * @return a feature check object indicating if it's enabled or disabled
     */
    @GET(OPPORTUNITIES_URI + "/enabled")
    Call<FeatureCheck> isEnabled();

    /**
     * Retrieve a paginated list of opportunities by filter
     *
     * @param filterId the id of the filter
     * @param perPage the amount per page
     * @param page the page to retrieve
     * @param embed the fields to embed
     * @return an opportunity api response
     */
    @GET(FILTERS_URI + "/{id}/" + OPPORTUNITIES_URI)
    Call<ApiResponse<Opportunity>> getOpportunitiesByFilter(@Path("id") int filterId,
                                                            @Query("per_page") int perPage,
                                                            @Query("page") int page,
                                                            @Query("embed") Embed embed);

    /**
     * Retrieve an opportunity by id
     *
     * @param id the id of the opportunity
     * @param embed the fields to embed
     * @return the opportunity
     */
    @GET(OPPORTUNITIES_URI + "/{id}")
    Call<Opportunity> getOpportunity(@Path("id") int id, @Query("embed") Embed embed);

    /**
     * Retrieve the opportunity timeline (history)
     *
     * @param opportunityId the opportunity id
     * @return the opportunity timeline
     */
    @GET(OPPORTUNITIES_URI + "/{id}/" + HISTORY_URI)
    Call<OpportunityTimeline> getOpportunityTimeline(@Path("id") int opportunityId);

    /**
     * Retrieve opportunity activities and events.
     *
     * @param opportunityId the opportunity id
     * @param perPage the amount per page
     * @param page the page to retrieve
     * @return the activities and events api response
     */
    @GET(OPPORTUNITIES_URI + "/{id}/" + ACTIVITIES_URI)
    Call<ApiResponse<IOpportunityActivity>> getOpportunityActivities(@Path("id") int opportunityId,
                                                                     @Query("per_page") int perPage,
                                                                     @Query("page") int page);

    /**
     * Search for opportunities
     *
     * @param query the query to search for
     * @param perPage the total opportunities per page
     * @param page the page requested
     * @param sortField the field to sort on
     * @param sortDirection the direction to sort
     * @param embed what to embed
     * @param fields the fields requested
     * @return an opportunity api response
     */
    @GET(OPPORTUNITIES_URI + "/" + SEARCH_URI)
    Call<ApiResponse<Opportunity>> searchOpportunities(@Query("q") String query, @Query("per_page") int perPage, @Query("page") int page,
                                                       @Query("sort_field") String sortField, @Query("sort_direction") SortDirection sortDirection,
                                                       @Query("embed") Embed embed, @Query("fields") Fields fields);

    /**
     * Retrieves a paginated list of all attachments for an opportunity
     *
     * @param opportunityId the id of the opportunity
     * @param perPage the total attachments per page
     * @param page the page requested
     * @return an attachment api response
     */
    @GET(OPPORTUNITIES_URI + "/{id}/" + ATTACHMENTS_URI)
    Call<ApiResponse<OpportunityAttachment>> getAttachments(@Path("id") int opportunityId, @Query("per_page") int perPage, @Query("page") int page);
}
