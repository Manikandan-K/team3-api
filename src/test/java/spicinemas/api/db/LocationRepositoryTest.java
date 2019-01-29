package spicinemas.api.db;

import org.flywaydb.core.Flyway;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.model.Location;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class LocationRepositoryTest {
    @Autowired
    DSLContext dslContext;
    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private Flyway flyway;

    @Before
    public  void init(){
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void shouldInsertLocationInDb(){

        String locationName = "Gurgaon";
        Location expectedLocation = new Location(locationName);
        locationRepo.addLocation(expectedLocation);
        Location actualLocation = locationRepo.getLocation(locationName);
        assertThat(actualLocation.getName(), is(expectedLocation.getName()));
    }
}
