package com.wborja.market.domain.repository;

import java.util.List;
import java.util.Optional;
import com.wborja.market.domain.Purchase;

public interface PurchaseRepository {
	List<Purchase> getAll();
	Optional<List<Purchase>> getByClient(int clientId);
	Purchase save (Purchase purchase);
}
