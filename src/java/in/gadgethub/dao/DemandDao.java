
package in.gadgethub.dao;

import in.gadgethub.pojo.DemandPojo;
import java.util.List;

/**
 *
 * @author Aditya Kumar Rai
 */
public interface DemandDao {
    public Boolean addProduct(DemandPojo demandPojo);
    public Boolean removeProduct(String userId, String prodId );
    public List<DemandPojo>haveDemanded(String prodId);
    
}