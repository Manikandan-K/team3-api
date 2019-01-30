package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Location;

import java.util.List;

@Repository
@Transactional
public class LocationRepository {

  @Autowired
  private DSLContext dslContext;


  public List<Location> getAllLocations() {
    return dslContext.select()
            .from(DSL.table("locations"))
            .fetchInto(Location.class);
  }

  public Location getLocation(String locationName) {
    return dslContext.select()
            .from(DSL.table("locations"))
            .where(DSL.field("locations.name").eq(locationName))
            .fetchOne()
            .into(Location.class);
  }

  public void addLocation(Location location) {
    dslContext.insertInto(
            DSL.table("locations"),

            DSL.field("name")
    )
            .values(
                    location.getName()
            )
            .execute();

  }
}
