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
package com.dharbor.set.fusion.dynamicentityservice.controller;

import com.dharbor.set.fusion.dynamicentityservice.repository.*;
import com.dharbor.set.fusion.dynamicentityservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController
public class ParticipantController {
    private final ParticipantRepository repository;

    @Autowired
    public ParticipantController(ParticipantRepository repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/participants/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) String id){
        Participant entity = repository.findOne(id);
        if(entity == null) {
            return ResponseEntity.notFound().build();
        }
        entity.setDeleted(true);
        repository.save(entity);
        return ResponseEntity.noContent().build();
    }
}
