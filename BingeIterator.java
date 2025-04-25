package src;

import java.util.Iterator;
import java.util.List;

class BingeIterator implements Iterator<Episode> {
    private List<Season> seasons;
    private Iterator<Episode> currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        this.currentIterator = seasons.get(0).iterator();  // Начинаем с первого сезона
    }

    @Override
    public boolean hasNext() {
        // Пока в текущем сезоне есть эпизоды, продолжаем обход
        while (!currentIterator.hasNext() && !seasons.isEmpty()) {
            seasons.remove(0);  // Убираем первый сезон
            if (!seasons.isEmpty()) {
                currentIterator = seasons.get(0).iterator();  // Переходим к следующему сезону
            }
        }
        return currentIterator.hasNext();
    }

    @Override
    public Episode next() {
        return currentIterator.next();  // Возвращаем следующий эпизод
    }
}
