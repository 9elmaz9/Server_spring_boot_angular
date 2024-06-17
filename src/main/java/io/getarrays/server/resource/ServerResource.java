package io.getarrays.server.resource;

import io.getarrays.server.model.Response;
import io.getarrays.server.model.Server;
import io.getarrays.server.service.implementation.ServerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.getarrays.server.enumeration.Status.SERVER_UP;
import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerResource {
    //private static final Logger logger = LoggerFactory.getLogger(ServerResource.class);

    private final ServerServiceImpl serverService;

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("servers", serverService.list(30)))
                        .message("Servers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Server server = serverService.ping(ipAddress);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("server", server))
                        .message(server.getStatus() == SERVER_UP ? "Ping success" : "Ping failed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveServer(@RequestBody @Valid Server server) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("servers", serverService.create(server)))
                        .message("Server created ")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long  id )   {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("servers", serverService.get(id)))
                        .message("Server retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long  id )   {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", serverService.delete(id)))
                        .message("Server deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
      );
  }

@GetMapping(path ="/image/{fileName}" , produces=IMAGE_PNG_VALUE)
public byte[] getServerImager(@PathVariable("fileName") String  fileName ) throws IOException {
    return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/images/"+fileName));
}



  // @GetMapping(path = "/image/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
  // public ResponseEntity<byte[]> getServerImage(@PathVariable("fileName") String fileName) {
  //     String filePath = "C:\\Users\\Intec\\Downloads\\images\\" + fileName;
  //     logger.info("Fetching image from path: {}", filePath);
  //     try {
  //         Path path = Paths.get(filePath);
  //         if (!Files.exists(path)) {
  //             logger.error("File not found: {}", filePath);
  //             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  //         }
  //         byte[] imageBytes = Files.readAllBytes(path);
  //         return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
  //     } catch (IOException e) {
  //         logger.error("Error reading file: {}", e.getMessage(), e);
  //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
  //     }
  // }


}


