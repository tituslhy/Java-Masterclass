/**
 * Notice the 'record' key word here.
 * Also notice the parenthesis right after the name of the record
 * All we need to do is input the parameters and we're done.
 * Only two lines and we rewrote the entire POJO in Student.Java
 * All input arguments are defined as private and final field with a
 * public accessor method - but not a get/is. For example to get the id,
 * just use id().
 * @param id
 * @param name
 * @param dateOfBirth
 * @param classList
 */
public record LPAStudent(
        String id,
        String name,
        String dateOfBirth,
        String classList
) {
}
