/*Digital Harbor International, Inc. makes no representations or warranties with respect to the contents or use of this manual,
and specifically disclaims any express or implied warranties of merchantability or fitness for any particular purpose. Digital
Harbor, Inc. reserves the right to revise this publication and to make changes to its content, at any time, without obligation to
notify any person or entity of such revisions or changes. Digital Harbor International, Inc. makes no representations or
warranties with respect to any Digital Harbor software, and specifically disclaims any express or implied warranties of
merchantability or fitness for any particular purpose. There are no warranties that extend beyond the descriptions contained in
these paragraphs. No warranty may be created or extended by sales representatives or written sales materials. Digital Harbor,
Inc. reserves the right to make changes to any and all parts of Digital Harbor software, at any time, without any obligation to
notify any person or entity of such changes. Digital Harbor, Inc. shall not be liable for any loss of profit or any other commercial
damages, including but not limited to special, incidental, consequential, or other damages.

Copyright © 2002-2018, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
photocopying, recording, or otherwise, without written permission of Digital Harbor.*/
package com.dharbor.set.fusion.dynamicentityservice.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;

/**
 * Created by sjanardan on 11-01-2018.
 */
@Component
public class GenericMetaDataInfo implements InfoContributor{

    String persistenceBuilderVersion;
    String dynamicServiceVersion;
    String publishedDateOfDynamicEntityService;

    GenericMetaDataInfo(){
        this.persistenceBuilderVersion = "2.0.0-SNAPSHOT";
        this.dynamicServiceVersion = "0.0.1-SNAPSHOT";
        this.publishedDateOfDynamicEntityService = "2018-Feb-15 21:17:25";
    }

    @Override
        public void contribute(Info.Builder builder) {
            builder.withDetail("persistenceBuilderVersion", this.persistenceBuilderVersion);
            builder.withDetail("dynamicServiceVersion",this.dynamicServiceVersion);
            builder.withDetail("publishedDateOfDynamicEntityService",this.publishedDateOfDynamicEntityService);
        }

    public String getPersistenceBuilderVersion(){
        return persistenceBuilderVersion;
    }

    public String getDynamicServiceVersion(){
        return dynamicServiceVersion;
    }

    public String getPublishedDateOfDynamicEntityService(){
            return publishedDateOfDynamicEntityService;
        }

}