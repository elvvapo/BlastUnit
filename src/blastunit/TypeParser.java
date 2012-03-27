/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blastunit;

/**
 *
 * @author fhernan9
 */
public class TypeParser {

    private static final int TYPE_DNA = 0;
    private static final int TYPE_RNA = 1;
    private static final int TYPE_PROTEIN = 2;
    private static final double SEQ_TRESHOLD = .85;

    public int isType(String sequence) {
        String re = "[acgtnACGTN]+";
        String[] strings = sequence.split(re);//re.split(sequence); //split the string into an array based on the reg expression 
        int notATCGN = 0;

        for (int i = 0; i < strings.length; i++) {
            notATCGN +=
                    strings[i].length();
        }

        int length = sequence.length();

        int nucleotides = length - notATCGN;

        String rerna = "[uU]+";

        strings = sequence.split(rerna);

        int notUs = 0;

        for (int i = 0; i < strings.length; i++) {
            notUs += strings[i].length();
        }

        int numUs = sequence.length() - notUs;

        if (nucleotides / (double) length > SEQ_TRESHOLD) {
            return TYPE_DNA;
        } else if ((nucleotides + numUs) / (double) length > SEQ_TRESHOLD) {
            return TYPE_RNA;
        } else {
            return TYPE_PROTEIN;
        }
    }

}
