/**LA AUDITORIA NO FUNCIONA CON QUERYS NATIVAS NI CON JPQUERIES
 * */
package com.pablovass.persistence.audit;

import com.pablovass.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {
    private PizzaEntity currentValue;
    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity entity){
        System.out.println("POST PERSISTE OR UPDATE");
        System.out.println("OLD VALUE "+ this.currentValue.toString());// asi esto si creo un registro nuevo me da un null pointer hay que refactorearlo
        System.out.println("NEW VALUE " + entity.toString());
    }
    @PreRemove
    public void onPreDelete(PizzaEntity entity){
        System.out.println(entity.toString());
    }
    @PostLoad // al crear un registro nuevo , te queda el currentValue que se lanzon ante asi que tengo que refactorear
    public  void postLoad(PizzaEntity entity){
        System.out.println("POST LOAD");
        this.currentValue= SerializationUtils.clone(entity);
        System.out.println(entity.toString());
    }
}
