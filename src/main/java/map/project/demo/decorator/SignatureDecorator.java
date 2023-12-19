package map.project.demo.decorator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import map.project.demo.model.Buch;

@Data
@AllArgsConstructor
public class SignatureDecorator extends Buch {
    private Buch decoratedBuch;
    private String authorSignature;

    @Override
    public String toString() {
        return decoratedBuch.toString() + ", Author's Signature: " + authorSignature;
    }
}
