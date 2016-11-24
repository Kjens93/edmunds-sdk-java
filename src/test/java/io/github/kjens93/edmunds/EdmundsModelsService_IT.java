package io.github.kjens93.edmunds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsModelsService_IT {

    private static final ModelsService edmunds = new EdmundsImpl("8zk4wr8dg5s9pv8hrwgerb5x");

    @Test
    public void test_findAllModels_getCount() {
        assertThat(edmunds.findAllModels("honda").count())
                .isBetween(10, 50);
        assertThatThrownBy(()->edmunds.findAllModels(null).count())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void test_findAllModels_getCount_state() {
        assertThat(edmunds.findAllModels("honda").state(State.NEW).count())
                .isBetween(3, 25);
        assertThat(edmunds.findAllModels("honda").state(State.USED).count())
                .isBetween(3, 25);
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).count())
                .isBetween(0, 10);
        assertThat(edmunds.findAllModels("honda").state(null).count())
                .isEqualTo(edmunds.findAllModels("honda").count());
    }

    @Test
    public void test_findAllModels_getCount_year() {
        assertThat(edmunds.findAllModels("honda").state(State.NEW).year(2010).count())
                .isEqualTo(0);
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).year(2010).count())
                .isEqualTo(0);
        assertThat(edmunds.findAllModels("honda").state(State.USED).year(2010).count())
                .isEqualTo(10);
        assertThat(edmunds.findAllModels("honda").year(2010).count())
                .isEqualTo(10);
    }

    @Test
    public void test_findAllModels_getCount_submodel() {
        assertThat(edmunds.findAllModels("honda").year(2010).submodel("").count())
                .isEqualTo(10);
    }

    @Test
    public void test_findAllModelsCount_makeNiceName_state_year_submodel_category() {
        assertThat(edmunds.findAllModels("honda").year(2010).category(Category.HATCHBACK_4DR).count())
                .isEqualTo(3);
        assertThat(edmunds.findAllModels("honda").year(2011).category(Category.COUPE).count())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("honda").year(2011).category(Category.SEDAN).count())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("honda").year(2011).category(Category.HATCHBACK_2DR).count())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("honda").year(1990).category(Category.WAGON).count())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("chevrolet").year(2012).category(Category.CONVERTIBLE).count())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PICKUP_REGULAR_CAB).count())
                .isEqualTo(4);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PICKUP_EXTENDED_CAB).count())
                .isEqualTo(4);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PICKUP_CREW_CAB).count())
                .isEqualTo(6);
        assertThat(edmunds.findAllModels("chevrolet").year(1995).category(Category.SUV_2DR).count())
                .isEqualTo(2);
        assertThat(edmunds.findAllModels("chevrolet").year(1995).category(Category.SUV_4DR).count())
                .isEqualTo(3);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.CARGO_VAN).count())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("chevrolet").year(2010).category(Category.PASSENGER_VAN).count())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("nissan").year(2014).category(Category.SUV_CONVERTIBLE).count())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("ford").year(2010).category(Category.CARGO_MINIVAN).count())
                .isEqualTo(1);
        assertThat(edmunds.findAllModels("ford").year(2010).category(Category.PASSENGER_MINIVAN).count())
                .isEqualTo(1);
    }

    @Test
    public void test_findAllModels_get() {
        assertThat(edmunds.findAllModels("honda").get())
                .hasSize(edmunds.findAllModels("honda").count())
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
                .hasSize(edmunds.findAllModels("honda").state(State.USED).count())
                .hasAtLeastOneElementOfType(Model.class);
        assertThat(edmunds.findAllModels("honda").state(State.NEW).get())
                .hasSize(edmunds.findAllModels("honda").state(State.NEW).count())
                .hasAtLeastOneElementOfType(Model.class);
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).get())
                .hasSize(edmunds.findAllModels("honda").state(State.FUTURE).count());
        assertThat(edmunds.findAllModels("honda").state(null).get())
                .hasSize(edmunds.findAllModels("honda").state(null).count())
                .containsExactlyElementsOf(edmunds.findAllModels("honda").get());
    }

    @Test
    public void test_findAllModels_get_year() {
        assertThat(edmunds.findAllModels("honda").state(State.USED).year(2010).get())
                .hasSize(edmunds.findAllModels("honda").state(State.USED).year(2010).count())
                .hasAtLeastOneElementOfType(Model.class);
        assertThat(edmunds.findAllModels("honda").state(State.NEW).year(2010).get())
                .hasSize(edmunds.findAllModels("honda").state(State.NEW).year(2010).count())
                .hasAtLeastOneElementOfType(Model.class);
        assertThat(edmunds.findAllModels("honda").state(State.FUTURE).year(2010).get())
                .hasSize(edmunds.findAllModels("honda").state(State.FUTURE).year(2010).count());
        assertThat(edmunds.findAllModels("honda").year(2010).get())
                .hasSize(edmunds.findAllModels("honda").year(2010).count());
    }

    @Test
    public void test_findAllModels_get_submodel() {
        assertThat(edmunds.findAllModels("honda").submodel("").get())
                .hasSize(edmunds.findAllModels("honda").submodel("").count());
    }

    @Test
    public void test_findAllModels_get_category() {
        assertThat(edmunds.findAllModels("honda").category(Category.SUV_4DR).get())
                .hasSize(edmunds.findAllModels("honda").category(Category.SUV_4DR).count());
    }

}
