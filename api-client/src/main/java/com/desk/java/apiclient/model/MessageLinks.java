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


import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class MessageLinks extends Links implements Serializable {

    private static final long serialVersionUID = 4451275198787767972L;

    private Link hiddenBy;
    private Link answersDisallowedBy;
    private Link user;
    private Link outboundMailbox;
    private Link sentBy;
    private Link enteredBy;
    @SerializedName("case")
    private Link caseLink;
    private Link twitterAccount;
    private Link createdBy;

    @NotNull
    public Link getHiddenBy() {
        return hiddenBy == null ? new Link() : hiddenBy;
    }

    public void setHiddenBy(@Nullable Link hiddenBy) {
        this.hiddenBy = hiddenBy;
    }

    @NotNull
    public Link getAnswersDisallowedBy() {
        return answersDisallowedBy == null ? new Link() : answersDisallowedBy;
    }

    public void setAnswersDisallowedBy(@Nullable Link answersDisallowedBy) {
        this.answersDisallowedBy = answersDisallowedBy;
    }

    @NotNull
    public Link getOutboundMailbox() {
        return outboundMailbox == null ? new Link() : outboundMailbox;
    }

    public void setOutboundMailbox(@Nullable Link outboundMailbox) {
        this.outboundMailbox = outboundMailbox;
    }

    @NotNull
    public Link getUser() {
        return user == null ? new Link() : user;
    }

    public void setUser(@Nullable Link user) {
        this.user = user;
    }

    @NotNull
    public Link getSentBy() {
        return sentBy == null ? new Link() : sentBy;
    }

    public void setSentBy(@Nullable Link sentBy) {
        this.sentBy = sentBy;
    }

    @NotNull
    public Link getEnteredBy() {
        return enteredBy == null ? new Link() : enteredBy;
    }

    public void setEnteredBy(@Nullable Link enteredBy) {
        this.enteredBy = enteredBy;
    }

    @NotNull
    public Link getCaseLink() {
        return caseLink == null ? new Link() : caseLink;
    }

    @NotNull
    public Link getTwitterAccount() {
        return twitterAccount == null ? new Link() : twitterAccount;
    }

    public void setTwitterAccount(Link twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    @NotNull
    public Link getCreatedBy() {
        return createdBy == null ? new Link() : createdBy;
    }

    public void setCreatedBy(@Nullable Link createdBy) {
        this.createdBy = createdBy;
    }
}
