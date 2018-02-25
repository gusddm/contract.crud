package contract.configuration.patch;

import java.lang.annotation.*;

/**
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PatchRequestBody {
}