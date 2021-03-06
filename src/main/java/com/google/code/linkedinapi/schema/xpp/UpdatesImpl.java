/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package com.google.code.linkedinapi.schema.xpp;

import com.google.code.linkedinapi.schema.Update;
import com.google.code.linkedinapi.schema.Updates;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdatesImpl
        extends BaseSchemaEntity
        implements Updates {

    /**
     *
     */
    private static final long serialVersionUID = -6353261321228473792L;
    protected List<Update> updateList;
    protected Long total;
    protected Long count;
    protected Long start;


    public List<Update> getUpdateList() {
        if (updateList == null) {
            updateList = new ArrayList<Update>();
        }
        return this.updateList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long value) {
        this.total = value;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long value) {
        this.count = value;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long value) {
        this.start = value;
    }

    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
        setStart(XppUtils.getAttributeValueAsLongFromNode(parser, "start"));
        setCount(XppUtils.getAttributeValueAsLongFromNode(parser, "count"));

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();

            if (name.equals("update")) {
                UpdateImpl updateImpl = new UpdateImpl();
                updateImpl.init(parser);
                getUpdateList().add(updateImpl);
            } else {
                // Consume something we don't understand.
                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }

    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "updates");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        XppUtils.setAttributeValueToNode(element, "start", getStart());
        XppUtils.setAttributeValueToNode(element, "count", getCount());
        for (Update update : getUpdateList()) {
            ((UpdateImpl) update).toXml(serializer);
        }
        serializer.endTag(null, "updates");
    }
}
