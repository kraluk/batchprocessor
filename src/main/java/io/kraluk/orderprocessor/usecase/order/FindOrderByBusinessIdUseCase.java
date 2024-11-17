package io.kraluk.orderprocessor.usecase.order;

import io.kraluk.orderprocessor.domain.order.entity.Order;
import io.kraluk.orderprocessor.domain.order.port.OrderRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class FindOrderByBusinessIdUseCase {

  private final OrderRepository repository;

  public FindOrderByBusinessIdUseCase(final OrderRepository repository) {
    this.repository = repository;
  }

  public Optional<Order> invoke(final Command command) {
    return repository.findByBusinessId(command.businessId());
  }

  public record Command(UUID businessId) {
    public static Command of(final UUID businessId) {
      return new Command(businessId);
    }
  }
}
