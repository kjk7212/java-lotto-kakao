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

	public void addLotto(Lotto lotto) {
		lottos.add(lotto);
	}

	public void addLotto(Lottos lottos) {
		this.lottos.addAll(lottos.lottos);
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public int getLottosSize() {
		return this.lottos.size();
	}
}
