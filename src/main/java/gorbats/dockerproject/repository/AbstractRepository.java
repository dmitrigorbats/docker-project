package gorbats.dockerproject.repository;

import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.UpdatableRecord;

public class AbstractRepository <T extends UpdatableRecord<T>, E>{

  @Inject
  protected DSLContext dsl;

  protected E insert(final Object source, final Class<? extends E> type) {
    final T record = newRecord();
    record.from(source);
    insert(record);
    return record.into(type);
  }

  protected void insert(final T updatableRecord) {
    dsl.attach(updatableRecord);
    updatableRecord.insert();
  }

  protected T newRecord() {
    throw new RuntimeException("Implement in sub class");
  }
}
