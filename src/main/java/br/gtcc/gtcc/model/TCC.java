/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gtcc.gtcc.model;

import java.time.LocalDateTime;
import org.dizitart.no2.collection.NitriteId;
import org.dizitart.no2.index.IndexType;
import org.dizitart.no2.repository.annotations.Entity;
import org.dizitart.no2.repository.annotations.Id;
import org.dizitart.no2.repository.annotations.Index;
import org.dizitart.no2.repository.annotations.Indices;

/**
 *
 * @author mrbee
 * 
 * Entidade que representa o TCC e a Banca 
 * Essa esntidade tem relação com a entidae usuário por meio de Id's
 */
@Entity
@Indices({
    @Index( fields = "idOrientador" , type = IndexType.UNIQUE)
})
public class TCC {
    
    @Id
    NitriteId id;                               // Id do Tcc
    NitriteId idAluno;                          // Id do aluno  que relacionado a este tcc 
    NitriteId idOrientador;                     // Id do professor orientador deste tcc 
    private String title;                       // String que representa o titulo do tcc
    private String theme;                       // String que representa o tema do tcc
    private String curse;                       // String que representa curso do tcc
    private LocalDateTime dateOfApresentation;  // Date que representa a data de apresentação do tcc
            
}
