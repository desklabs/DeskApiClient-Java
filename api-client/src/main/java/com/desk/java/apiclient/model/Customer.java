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

package com.desk.java.apiclient.model;


import com.desk.java.apiclient.util.StringUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Serializable {

    private static final long serialVersionUID = 6378489591680023162L;

    private int id;
    private String firstName;
    private String lastName;
    private String avatar;
    private String title;
    private String language;
    private String background;
    private String companyName;
    private String displayName;
    private CustomerContact[] emails;
    private CustomerContact[] addresses;
    private CustomerContact[] phoneNumbers;
    private CustomerLinks _links;
    private HashMap<String, String> customFields;
    private CustomerEmbedded _embedded;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    public String getName() {
        StringBuilder name = new StringBuilder();

        if (!StringUtils.isEmpty(getFirstName())) {
            name.append(getFirstName());
        }

        if (!StringUtils.isEmpty(getLastName())) {
            if (name.length() > 0) {
                name.append(" ");
            }
            name.append(getLastName());
        }

        return name.toString();
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Nullable
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Nullable
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Nullable
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Nullable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @NotNull
    public CustomerContact[] getEmails() {
        return emails != null ? emails : new CustomerContact[0];
    }

    public void setEmails(CustomerContact... emails) {
        this.emails = emails;
    }

    @NotNull
    public CustomerContact[] getAddresses() {
        return addresses != null ? addresses : new CustomerContact[0];
    }

    public void setAddresses(CustomerContact... addresses) {
        this.addresses = addresses;
    }

    @NotNull
    public CustomerContact[] getPhoneNumbers() {
        return phoneNumbers != null ? phoneNumbers : new CustomerContact[0];
    }

    public void setPhoneNumbers(CustomerContact... phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @NotNull
    public CustomerLinks getLinks() {
        return _links == null ? _links = new CustomerLinks() : _links;
    }

    public void setLinks(CustomerLinks links) {
        this._links = links;
    }

    @NotNull
    public Map<String, String> getCustomFields() {
        return customFields != null ? customFields : Collections.<String, String>emptyMap();
    }

    public void setCustomFields(HashMap<String, String> customFields) {
        this.customFields = customFields;
    }

    @NotNull
    public CustomerEmbedded getEmbedded() {
        return _embedded == null ? _embedded = new CustomerEmbedded() : _embedded;
    }

    public void setEmbedded(CustomerEmbedded embedded) {
        this._embedded = embedded;
    }

    /**
     * Gets the first email
     * @return the first email or null if no email
     */
    @Nullable
    public String getFirstEmail() {
        if (getEmails().length == 0) {
            return null;
        }
        return getEmails()[0].getValue();
    }

    /**
     * Gets the first phone number
     * @return the first phone number or null if no phone number exists
     */
    @Nullable
    public String getFirstPhone() {
        if (getPhoneNumbers().length == 0) {
            return null;
        }
        return getPhoneNumbers()[0].getValue();
    }

    /**
     * Gets the handle of the first twitter user
     * @return the handle of the first twitter user or null if no twitter user
     */
    @Nullable
    public String getTwitterHandle() {
        if (getTwitterUser() == null) {
            return null;
        }
        return getTwitterUser().getHandle();
    }

    /**
     * Gets the embedded facebook user
     * @return the embedded facebook user or null if there is no embedded facebook user
     */
    @Nullable
    public FacebookUser getFacebookUser() {
        return getEmbedded().getFacebookUser();
    }

    /**
     * Gets the embedded twitter user
     * @return the embedded twitter user or null if there is no embedded twitter user
     */
    @Nullable
    public TwitterUser getTwitterUser() {
        return getEmbedded().getTwitterUser();
    }

    /**
     * Gets the self link
     * @return the self link
     */
    @NotNull
    public Link getSelfLink() {
        return getLinks().getSelf();
    }

    /**
     * Get the company link or null if there is no company
     * @return the company link or null
     */
    @Nullable
    public Link getCompanyLink() {
        return getLinks().getCompany();
    }
}
