/* Service layer that communicates with the physical DB

 */
package com.shiva.webservices.restfulwebservices.twitter;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getAllUsers() {
        return "all twitters should show up here";
    }
}
