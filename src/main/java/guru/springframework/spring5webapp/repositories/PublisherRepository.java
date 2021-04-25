package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Gowtham C on 25/04/21.
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
