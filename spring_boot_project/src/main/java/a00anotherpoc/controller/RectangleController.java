package a00anotherpoc.controller;
// RectangleController.java
import a00anotherpoc.model.PA;
import a00anotherpoc.model.Rectangle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/rectangle")
public class RectangleController {

    @PostMapping
    public ResponseEntity<?> calculateAreaAndPerimeter(@RequestBody Rectangle rectangle) {
        double length = rectangle.getLength();
        double breadth = rectangle.getBreadth();

        if (length <= 0 || breadth <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid entry: Length and Breadth must be greater than zero.");
        }

        double area = length * breadth;
        double perimeter = 2 * (length + breadth);

        PA response = new PA(area, perimeter);
        return ResponseEntity.ok(response);
    }
}
