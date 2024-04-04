package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos() {
		this.lottos = new ArrayList<>();
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<List<Integer>> getLottoNumbersList() {
		return lottos.stream()
			.map(Lotto::getLottoNumbers)
			.collect(Collectors.toList());
	}

	public List<Lotto> getLottoList() {
		return Collections.unmodifiableList(lottoList);
	}
}
