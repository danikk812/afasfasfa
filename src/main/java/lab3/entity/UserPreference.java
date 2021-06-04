package lab3.entity;

import java.util.Objects;

public class UserPreference {
    private String favProducer;
    private String favGenre;
    private boolean cinema;
    private boolean home;
    private Format preference;

    public UserPreference() {
    }

    public UserPreference(String favProducer, String favGenre, boolean cinema, boolean home, Format preference) {
        this.favProducer = favProducer;
        this.favGenre = favGenre;
        this.cinema = cinema;
        this.home = home;
        this.preference = preference;
    }

    public String getFavProducer() {
        return favProducer;
    }

    public void setFavProducer(String favProducer) {
        this.favProducer = favProducer;
    }

    public boolean isCinema() {
        return cinema;
    }

    public void setCinema(boolean cinema) {
        this.cinema = cinema;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public String getFavGenre() {
        return favGenre;
    }

    public void setFavGenre(String favGenre) {
        this.favGenre = favGenre;
    }

    public Format getPreference() {
        return preference;
    }

    public void setPreference(Format preference) {
        this.preference = preference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPreference)) return false;
        UserPreference that = (UserPreference) o;
        return home == that.home && cinema == that.cinema && Objects.equals(favProducer, that.favProducer) && Objects.equals(favGenre, that.favGenre) && preference == that.preference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(favProducer, favGenre, home, cinema, preference);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserPreference{");
        sb.append("favProducer='").append(favProducer).append('\'');
        sb.append(", favGenre='").append(favGenre).append('\'');
        sb.append(", cinema=").append(cinema);
        sb.append(", home=").append(home);
        sb.append(", preference=").append(preference);
        sb.append('}');
        return sb.toString();
    }
}
