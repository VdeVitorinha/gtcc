package br.gtcc.gtcc.model;

import org.dizitart.no2.collection.NitriteId;
import org.dizitart.no2.index.IndexType;
import org.dizitart.no2.repository.annotations.Entity;
import org.dizitart.no2.repository.annotations.Id;
import org.dizitart.no2.repository.annotations.Index;
import org.dizitart.no2.repository.annotations.Indices;

import java.util.List;
import br.gtcc.gtcc.model.UserType;
import java.util.Date;

/*
    Entidade de Usuarios com seus atributos. O tipo de usuário aluno não   
*/

@Entity
@Indices({
    @Index(fields = "registration", type = IndexType.UNIQUE)
})
public class Users {
    
    @Id
    NitriteId id ;
    private String name;                // Nome do usuário
    private String email;               // Email do usuário
    private String registration;        // Matricula do usuário
    private List<UserType> userType;    // Tipo de usuário podendo ser PROFESSOR, ALUNO, COORDENADOR, e tambem COORDENADOR/PROFESSOR
    private Date birthdate;             // Data de aniversário do usuário
    private int cellphone;              // Telefone do usuário
}
