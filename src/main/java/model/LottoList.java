package model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
	private final List<Lotto> lottoList;

	public LottoList(List<Lotto> lottoList) {
		this.lottoList = lottoList;
	}

	public List<List<Integer>> getLottoNumbersList() {
		return lottoList.stream()
			.map(Lotto::getLottoNumbers)
			.collect(Collectors.toList());
	}

	public List<Lotto> getLottoList() {
		return Collections.unmodifiableList(lottoList);
	}
}
