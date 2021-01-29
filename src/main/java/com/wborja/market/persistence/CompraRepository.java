package com.wborja.market.persistence;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wborja.market.domain.Purchase;
import com.wborja.market.domain.repository.PurchaseRepository;
import com.wborja.market.persistence.crud.CompraCrudRepository;
import com.wborja.market.persistence.entity.Compra;
import com.wborja.market.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository {
	
	@Autowired
	CompraCrudRepository compraCrudRepository;
	
	@Autowired
	private PurchaseMapper purchaseMapper;

	@Override
	public List<Purchase> getAll() {
		return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
	}

	@Override
	public Optional<List<Purchase>> getByClient(int clientId) {
		return compraCrudRepository.findByIdCliente(clientId).map(compras -> purchaseMapper.toPurchases(compras));
	}

	@Override
	public Purchase save(Purchase purchase) {
		Compra compra = purchaseMapper.toCompra(purchase);
		compra.getProductos().forEach(producto -> producto.setCompra(compra));
		return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
	}
	

}
