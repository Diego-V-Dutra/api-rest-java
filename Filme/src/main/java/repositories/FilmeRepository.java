/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author diegosantos
 */
public interface FilmeRepository  extends JpaRepository<Filme, Long>{
    
}
