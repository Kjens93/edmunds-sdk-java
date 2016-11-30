package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.dtos.Make;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.services.MakesService;
import org.junit.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsMakesService_IT {

    private static final MakesService edmunds = new Edmunds(System.getenv("EDMUNDS_API_KEY"));
    private static final int thisYear = Calendar.getInstance().get(Calendar.YEAR);

    @Test
    public void test_findAllMakes_getCount() {
        assertThat(edmunds.findAllMakes().getCount())
                .isBetween(30, 100);
    }

    @Test
    public void test_findAllMakes_getCount_state() {
        assertThat(edmunds.findAllMakes().state(State.FUTURE).getCount())
                .isBetween(10,30);
        assertThat(edmunds.findAllMakes().state(State.USED).getCount())
                .isBetween(50,75);
        assertThat(edmunds.findAllMakes().state(State.NEW).getCount())
                .isBetween(30,60);
    }

    @Test
    public void test_findAllMakes_getCount_state_year() {
        assertThat(edmunds.findAllMakes().state(State.FUTURE).year(thisYear).getCount())
                .isBetween(1, 10);
        assertThat(edmunds.findAllMakes().state(State.USED).year(thisYear).getCount())
                .isBetween(30, 60);
        assertThat(edmunds.findAllMakes().state(State.NEW).year(thisYear).getCount())
                .isBetween(30, 60);
        assertThat(edmunds.findAllMakes().year(thisYear).getCount())
                .isBetween(30, 60);
    }

    @Test
    public void test_findAllMakes_get() {
        assertThat(edmunds.findAllMakes().get())
                .hasSize(edmunds.findAllMakes().getCount())
                .allMatch(m->m.getId() != 0)
                .allMatch(m->m.getName() != null)
                .allMatch(m->!m.getName().isEmpty())
                .allMatch(m->m.getNiceName() != null)
                .allMatch(m->!m.getNiceName().isEmpty())
                .allMatch(m->!m.getModels().isEmpty())
                .allMatch(m->m.getModels().stream()
                        .allMatch(d->d.getId() != null && !d.getId().isEmpty()));

    }

    @Test
    public void test_findAllMakes_get_state() {
        assertThat(edmunds.findAllMakes().state(State.NEW).get())
                .hasSize(edmunds.findAllMakes().state(State.NEW).getCount());
        assertThat(edmunds.findAllMakes().state(State.USED).get())
                .hasSize(edmunds.findAllMakes().state(State.USED).getCount());
        assertThat(edmunds.findAllMakes().state(State.FUTURE).get())
                .hasSize(edmunds.findAllMakes().state(State.FUTURE).getCount());
        assertThat(edmunds.findAllMakes().state(null).get())
                .hasSize(edmunds.findAllMakes().state(null).getCount())
                .hasSize(edmunds.findAllMakes().getCount())
                .isEqualTo(edmunds.findAllMakes().get());
    }

    @Test
    public void test_findAllMakes_get_state_year() {
        assertThat(edmunds.findAllMakes().year(thisYear).get())
                .hasSize(edmunds.findAllMakes().year(thisYear).getCount())
                .hasAtLeastOneElementOfType(Make.class);
    }

}
