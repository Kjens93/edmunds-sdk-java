package io.github.kjens93.edmunds;

import org.junit.Test;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsMakesService_IT {

    private static final MakesService edmunds = new EdmundsImpl("8zk4wr8dg5s9pv8hrwgerb5x");
    private static final int thisYear = Calendar.getInstance().get(Calendar.YEAR);

    @Test
    public void test_findAllMakes_getCount() {
        assertThat(edmunds.findAllMakes().count())
                .isBetween(30, 100);
    }

    @Test
    public void test_findAllMakes_getCount_async() throws InterruptedException, TimeoutException, ExecutionException {
        assertThat(edmunds.findAllMakes().countAsync(null).get(10, TimeUnit.SECONDS))
                .isBetween(30, 100);
    }

    @Test
    public void test_findAllMakes_getCount_state() {
        assertThat(edmunds.findAllMakes().state(State.FUTURE).count())
                .isBetween(10,30);
        assertThat(edmunds.findAllMakes().state(State.USED).count())
                .isBetween(50,75);
        assertThat(edmunds.findAllMakes().state(State.NEW).count())
                .isBetween(30,60);
    }

    @Test
    public void test_findAllMakes_getCount_state_year() {
        assertThat(edmunds.findAllMakes().state(State.FUTURE).year(thisYear).count())
                .isBetween(1, 10);
        assertThat(edmunds.findAllMakes().state(State.USED).year(thisYear).count())
                .isBetween(30, 60);
        assertThat(edmunds.findAllMakes().state(State.NEW).year(thisYear).count())
                .isBetween(30, 60);
        assertThat(edmunds.findAllMakes().year(thisYear).count())
                .isBetween(30, 60);
    }

    @Test
    public void test_findAllMakes_get() {
        assertThat(edmunds.findAllMakes().get())
                .hasSize(edmunds.findAllMakes().count())
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
                .hasSize(edmunds.findAllMakes().state(State.NEW).count());
        assertThat(edmunds.findAllMakes().state(State.USED).get())
                .hasSize(edmunds.findAllMakes().state(State.USED).count());
        assertThat(edmunds.findAllMakes().state(State.FUTURE).get())
                .hasSize(edmunds.findAllMakes().state(State.FUTURE).count());
        assertThat(edmunds.findAllMakes().state(null).get())
                .hasSize(edmunds.findAllMakes().state(null).count())
                .hasSize(edmunds.findAllMakes().count())
                .isEqualTo(edmunds.findAllMakes().get());
    }

    @Test
    public void test_findAllMakes_get_state_year() {
        assertThat(edmunds.findAllMakes().year(thisYear).get())
                .hasSize(edmunds.findAllMakes().year(thisYear).count())
                .hasAtLeastOneElementOfType(Make.class);
    }

}
