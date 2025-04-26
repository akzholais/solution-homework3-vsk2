package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private List<Iterator<Episode>> seasonIterators;
    private Iterator<Episode> currentIterator;

    public BingeIterator(List<Season> seasons) {
        seasonIterators = new ArrayList<>();
        for (Season season : seasons) {
            seasonIterators.add(season.iterator());  // Добавляем итератор для каждого сезона
        }
        this.currentIterator = seasonIterators.isEmpty() ? null : seasonIterators.get(0);
    }

    @Override
    public boolean hasNext() {
        // Перебор всех сезонов
        while (currentIterator != null && !currentIterator.hasNext()) {
            seasonIterators.remove(0);  // Убираем пустой итератор
            currentIterator = seasonIterators.isEmpty() ? null : seasonIterators.get(0);  // Переходим к следующему сезону
        }
        return currentIterator != null && currentIterator.hasNext();  // Проверка наличия следующего эпизода
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more episodes");
        }
        return currentIterator.next();  // Возвращаем следующий эпизод
    }
}
