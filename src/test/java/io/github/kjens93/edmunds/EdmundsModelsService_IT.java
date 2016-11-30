package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.dtos.Model;
import io.github.kjens93.edmunds.services.ModelsService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsModelsService_IT {

    private static final ModelsService edmunds = new Edmunds(System.getProperty("EDMUNDS_API_KEY"));

    @Test
    public void test_findAllModels_getCount() {
        assertThat(edmunds.findAllModels("honda").getCount())
                .isBetween(10, 50);
        assertThatThrownBy(()->edmunds.findAllModels(null).getCount())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void test_findAllModels_getCount_state() {
        assertThat(edmunds.findAllModels("honda").state(State.NEW).getCount())
                .isBetween(3, 25);
        assertThat(edmunds.findAllModels("honda").state(State.USED).getCount())
                .isBetween(3, 25);
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).getCount())
                .isBetween(0, 10);
        assertThat(edmunds.findAllModels("honda").state(null).getCount())
                .isEqualTo(edmunds.findAllModels("honda").getCount());
    }

    @Test
    public void test_findAllModels_getCount_year() {
        assertThat(edmunds.findAllModels("honda").state(State.NEW).year(2010).getCount())
                .isEqualTo(0);
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).year(2010).getCount())
                .isEqualTo(0);
        assertThat(edmunds.findAllModels("honda").state(State.USED).year(2010).getCount())
                .isEqualTo(10);
        assertThat(edmunds.findAllModels("honda").year(2010).getCount())
                .isEqualTo(10);
    }

    @Test
    public void test_findAllModels_getCount_submodel() {
        assertThat(edmunds.findAllModels("honda").year(2010).submodel("").getCount())
                .isEqualTo(10);
    }

    @Test
    public void test_findAllModelsCount_makeNiceName_state_year_submodel_category() {
        assertThat(edmunds.findAllModels("honda").year(2010).category(Category.HATCHBACK_4DR).getCount())
                .isEqualTo(3);
        assertThat(edmunds.findAllModels("honda").year(2011).category(Category.COUPE).getCount())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("honda").year(2011).category(Category.SEDAN).getCount())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("honda").year(2011).category(Category.HATCHBACK_2DR).getCount())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("honda").year(1990).category(Category.WAGON).getCount())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("chevrolet").year(2012).category(Category.CONVERTIBLE).getCount())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PICKUP_REGULAR_CAB).getCount())
                .isEqualTo(4);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PICKUP_EXTENDED_CAB).getCount())
                .isEqualTo(4);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PICKUP_CREW_CAB).getCount())
                .isEqualTo(6);
        assertThat(edmunds.findAllModels("chevrolet").year(1995).category(Category.SUV_2DR).getCount())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("chevrolet").year(1995).category(Category.SUV_4DR).getCount())
                .isEqualTo(3);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.CARGO_VAN).getCount())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PASSENGER_VAN).getCount())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("nissan").year(2014).category(Category.SUV_CONVERTIBLE).getCount())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("ford").year(2010).category(Category.CARGO_MINIVAN).getCount())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("ford").year(2010).category(Category.PASSENGER_MINIVAN).getCount())
                .isEqualTo(1);
    }

    @Test
    public void test_findAllModels_get() {
        assertThat(edmunds.findAllModels("honda").get())
                .hasSize(edmunds.findAllModels("honda").getCount())
                .hasAtLeastOneElementOfType(Model.class)
                .allMatch(m->m.getId() != null)
                .allMatch(m->!m.getId().isEmpty())
                .allMatch(m->m.getNiceName() != null)
                .allMatch(m->!m.getNiceName().isEmpty())
                .allMatch(m->m.getName() != null);
        assertThatThrownBy(()->edmunds.findAllModels(null).get())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void test_findAllModels_get_state() {
        assertThat(edmunds.findAllModels("honda").state(State.USED).get())
                .hasSize(edmunds.findAllModels("honda").state(State.USED).getCount())
                .hasAtLeastOneElementOfType(Model.class);
        assertThat(edmunds.findAllModels("honda").state(State.NEW).get())
                .hasSize(edmunds.findAllModels("honda").state(State.NEW).getCount())
                .hasAtLeastOneElementOfType(Model.class);
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).get())
                .hasSize(edmunds.findAllModels("honda").state(State.FUTURE).getCount());
        assertThat(edmunds.findAllModels("honda").state(null).get())
                .hasSize(edmunds.findAllModels("honda").state(null).getCount())
                .containsExactlyElementsOf(edmunds.findAllModels("honda").get());
    }

    @Test
    public void test_findAllModels_get_year() {
        assertThat(edmunds.findAllModels("honda").state(State.USED).year(2010).get())
                .hasSize(edmunds.findAllModels("honda").state(State.USED).year(2010).getCount())
                .hasAtLeastOneElementOfType(Model.class);
        assertThat(edmunds.findAllModels("honda").state(State.NEW).year(2010).get())
                .hasSize(edmunds.findAllModels("honda").state(State.NEW).year(2010).getCount());
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).year(2010).get())
                .hasSize(edmunds.findAllModels("honda").state(State.FUTURE).year(2010).getCount());
        assertThat(edmunds.findAllModels("honda").year(2010).get())
                .hasSize(edmunds.findAllModels("honda").year(2010).getCount());
    }

    @Test
    public void test_findAllModels_get_submodel() {
        assertThat(edmunds.findAllModels("honda").submodel("").get())
                .hasSize(edmunds.findAllModels("honda").submodel("").getCount());
    }

    @Test
    public void test_findAllModels_get_category() {
        assertThat(edmunds.findAllModels("honda").category(Category.SUV_4DR).get())
                .hasSize(edmunds.findAllModels("honda").category(Category.SUV_4DR).getCount());
    }

}
