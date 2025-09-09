package ec.com.giocompany.cajaahorro.user.controller;


import java.util.Map;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.com.giocompany.cajaahorro.user.model.pojo.User;
import ec.com.giocompany.cajaahorro.user.model.request.CreateUserRequest;
import ec.com.giocompany.cajaahorro.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Products Controller", description = "Microservicio encargado de exponer operaciones CRUD sobre USUARIOS alojados en una base de datos")
public class UserController {

    private final UserService service;

    @GetMapping("/users")
    @Operation(
            operationId = "Autenticar usuarios",
            description = "Operacion de lectura",
            summary = "Se devuelve un usuario  almacenado en la base de datos.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))

    public ResponseEntity<User> getAutenticarUsuario(
            @RequestHeader Map<String, String> headers,
            @Parameter(name = "userNom", description = "Nombre de Usuario", example = "cgipiale", required = false)
            @RequestParam(required = false) String userNom,
            @Parameter(name = "userPwd", description = "Password de usuario", example = "XXXX", required = false)
            @RequestParam(required = false) String userPwd) {

        log.info("headers: {}", headers);
        log.info("nombre usuario: ", userNom);
        log.info("password: ", userPwd);

        User user = service.autenticarUsuario(userNom, userPwd);


        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/users/{userId}")
    @Operation(
            operationId = "Obtener un usuario",
            description = "Operacion de lectura",
            summary = "Se devuelve un usuario a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el usuario con el identificador indicado.")

    public ResponseEntity<User> buscarUsuario(@PathVariable String userId) {

        log.info("Request received for product {}", userId);
        User user = service.buscarUsuario(userId);

        log.info("Usuario Encontrado:", user);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @PostMapping("/users")
    @Operation(
            operationId = "Insertar un usuario",
            description = "Operacion de escritura",
            summary = "Se crea un usuario a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del usuario a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateUserRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el usuario con el identificador indicado.")
    public ResponseEntity<User> addUser(@RequestBody CreateUserRequest request) {

        User createdUser = service.createUser(request);

        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



/*
    @DeleteMapping("/products/{productId}")
    @Operation(
            operationId = "Eliminar un producto",
            description = "Operacion de escritura",
            summary = "Se elimina un producto a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {

        Boolean removed = service.removeProduct(productId);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
*/
    /*
    @PostMapping("/products")
    @Operation(
            operationId = "Insertar un producto",
            description = "Operacion de escritura",
            summary = "Se crea un producto a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateUserRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<User> addProduct(@RequestBody CreateUserRequest request) {

        User createdProduct = service.createProduct(request);

        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

*/
    /*
    @PatchMapping("/products/{productId}")
    @Operation(
            operationId = "Modificar parcialmente un producto",
            description = "RFC 7386. Operacion de escritura",
            summary = "RFC 7386. Se modifica parcialmente un producto.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a crear.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = String.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Producto inválido o datos incorrectos introducidos.")
    public ResponseEntity<User> patchProduct(@PathVariable String productId, @RequestBody String patchBody) {

        User patched = service.updateProduct(productId, patchBody);
        if (patched != null) {
            return ResponseEntity.ok(patched);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/products/{productId}")
    @Operation(
            operationId = "Modificar totalmente un producto",
            description = "Operacion de escritura",
            summary = "Se modifica totalmente un producto.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a actualizar.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = UserDto.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Producto no encontrado.")
    public ResponseEntity<User> updateProduct(@PathVariable String productId, @RequestBody UserDto body) {

        User updated = service.updateProduct(productId, body);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

   /* @PostMapping("/roles")
    @Operation(
            operationId = "Insertar un producto",
            description = "Operacion de escritura",
            summary = "Se crea un producto a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateUserRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<User> addProduct(@RequestBody CreateUserRequest request) {

        User createdProduct = service.createProduct(request);

        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }*/



}
