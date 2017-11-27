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

Copyright © 2002-2017, Digital Harbor, Inc. All rights reserved. No part of this publication, including its interior design and\
icons, may be reproduced, stored in a retrieval system, or transmitted in any form by any means, electronic, mechanical,
photocopying, recording, or otherwise, without written permission of Digital Harbor.*/

package com.dharbor.set.fusion.dynamicentityservice.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import org.springframework.stereotype.Repository;
import com.dharbor.set.fusion.dynamicentityservice.model.*;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
         	config.exposeIdsFor(_56a3b6581cc14aacbb123a4fb3d86924.class);
         	config.exposeIdsFor(_89ae45aedf2e4120aab29e9b0b0a78b7.class);
         	config.exposeIdsFor(_3377aa29172543d1ab8faaf647fdb867.class);
         	config.exposeIdsFor(_2f173291df1e4320aab29e9b0b0a78b7.class);
         	config.exposeIdsFor(_8b59a20914e64a48a7f84eabcfc118cb.class);
         	config.exposeIdsFor(_ca98529941b3449daa514284866eb762.class);
         	config.exposeIdsFor(_f12e7e73496f4cfcab511d4403fda88d.class);
    }
}