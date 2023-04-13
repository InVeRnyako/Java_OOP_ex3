import java.io.Serializable;
import java.util.Objects;

public class Parent implements Serializable {
    private Integer idKid;
    private Integer idParent;

    Parent(Integer idKid, Integer idParent) {
        this.idKid = idKid;
        this.idParent = idParent;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Parent)) {
            return false;
        }
        Parent parent = (Parent) o;
        return Objects.equals(idKid, parent.idKid) && Objects.equals(idParent, parent.idParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKid, idParent);
    }

    public Integer getIdKid() {
        return idKid;
    }

    public Integer getIdParent() {
        return idParent;
    }


}
