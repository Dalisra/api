/*
 * Copyright 2021 vytautas.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dalisra;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import javax.annotation.security.RolesAllowed;

/**
 * @author vytautas
 */
@Controller("/")
@Secured(SecurityRule.IS_ANONYMOUS)
public class InputController{

    private static final Logger log = LoggerFactory.getLogger(InputController.class);

    @Post(produces = MediaType.TEXT_PLAIN)
    public Mono<String> insertData(){
        log.debug("Incomming data..");
        return Mono.just("ok");
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public Mono<String> getInfo(){
        log.debug("Incomming get");
        return Mono.just("wazap");
    }
}
