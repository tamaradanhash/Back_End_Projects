package at.nacs.ex4theenglishgentleman;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@RequiredArgsConstructor
public class EnglishGentleman {
    private final Monocle monocle;
    private final Lighter lighter;
    private boolean read;
    private boolean smoked;

    public void smoke(Cigar cigar) throws CigarWasNotLitException {
        lighter.light(cigar);
        cigar.smoke();
        smoked = true;
    }

    public boolean isHasSmoked() {

        return smoked;
    }

    public void read(Newspaper newspaper) {
        monocle.read(newspaper);
        read = true;
    }

    public boolean isHasRead() {
        return read;
    }

    public boolean hadAGoodDay() {
        return read && smoked;
    }
}
