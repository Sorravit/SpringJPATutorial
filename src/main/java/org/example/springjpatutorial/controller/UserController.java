//package org.example.springjpatutorial.controller;
//
//public class UserController {
//    @RequestMapping("/users")
//    @RestController
//    public class UserController {
//        private final UserService userService;
//
//        public UserController(UserService userService) {
//            this.userService = userService;
//        }
//
//        @GetMapping("/me")
//        public ResponseEntity<User> authenticatedUser() {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//            User currentUser = (User) authentication.getPrincipal();
//
//            return ResponseEntity.ok(currentUser);
//        }
//
//        @GetMapping("/")
//        public ResponseEntity<List<User>> allUsers() {
//            List <User> users = userService.allUsers();
//
//            return ResponseEntity.ok(users);
//        }
//}
