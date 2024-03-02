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
 * Esta classe representa a data que vai ficar as apresentações 
 */
@Entity
@Indices({
    @Index(fields = "idApŕesentation", type = IndexType.UNIQUE),
})
public class Data {
    
    @Id             
    NitriteId id;                   // Id da data do calendário 
    NitriteId idApŕesentation;      // Id da Apresentação da Entidade de Apresentação Banca    
    private LocalDateTime date;     // Date data do calendário que vai esta livre ou não
    private boolean isFree = false;  // Booleano que representa se a data esta livre ou não 
}
