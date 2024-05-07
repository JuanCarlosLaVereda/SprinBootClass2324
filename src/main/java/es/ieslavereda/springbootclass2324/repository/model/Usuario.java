package es.ieslavereda.springbootclass2324.repository.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;

    @Override
    public boolean equals(Object object){
        if (object == null || object instanceof Usuario){
            return false;
        }
        Usuario usuario = (Usuario) object;

        return id == usuario.getId();
    }

    @Override
    public int hashCode(){
        return id;
    }

}
