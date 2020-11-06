package tx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :jty
 * @date :20-10-30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    private Integer id;
    private Integer userId;
    private Integer money;
}
