package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.IceCream;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream, Long>{

}
