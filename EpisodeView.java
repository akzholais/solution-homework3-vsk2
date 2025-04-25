package src;

class EpisodeView {
    private Episode episode;
    private int startOffset;

    public EpisodeView(Episode episode, int startOffset) {
        this.episode = episode;
        this.startOffset = startOffset;
    }

    public Episode getEpisode() {
        return episode;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public void play() {
        // Просто указываем информацию о том, что эпизод начнется с указанного времени.
        System.out.println("Playing: " + episode.getTitle() + " (Start from " + startOffset + " seconds)");
    }
}
