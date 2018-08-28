/*
 * Copyright 2002-2018 the original author or authors.
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

package sample.message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Rob Winch
 */
@RestController
@RequestMapping("/messages")
public class MessageController {
	private final MessageService messages;

	public MessageController(MessageService messages) {
		this.messages = messages;
	}

	@GetMapping
	List<Message> findAll() {
		return this.messages.findAll();
	}

	@GetMapping("/{email}")
	List<Message> findMessageByToUserEmail(@PathVariable String email, Map<String, Object> model) {
		return this.messages.findMessageByToUserEmail(email);
	}
}