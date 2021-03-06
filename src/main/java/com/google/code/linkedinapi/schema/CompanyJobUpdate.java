/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}job"/>
 *         &lt;element ref="{}action"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public interface CompanyJobUpdate
        extends SchemaEntity {


    /**
     * Gets the value of the job property.
     *
     * @return possible object is
     *         {@link Job }
     */
    Job getJob();

    /**
     * Sets the value of the job property.
     *
     * @param value allowed object is
     *              {@link Job }
     */
    void setJob(Job value);

    /**
     * Gets the value of the action property.
     *
     * @return possible object is
     *         {@link Action }
     */
    Action getAction();

    /**
     * Sets the value of the action property.
     *
     * @param value allowed object is
     *              {@link Action }
     */
    void setAction(Action value);

}
