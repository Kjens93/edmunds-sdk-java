package io.github.kjens93.edmunds;

import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsHttpService_IT {

    @Test
    public void test() {
        EdmundsHttpService httpService = new EdmundsHttpService("8zk4wr8dg5s9pv8hrwgerb5x");
        MakesCount vc = httpService.getOne(MakesCount.class, "/api/vehicle/v2/makes/count", new HashMap<String, Object>(){{
            put("view", "full");
        }});
        assertThat(vc.getMakesCount()).isBetween(10, 100);
    }

}
