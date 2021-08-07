package cat.gencat.darp.ervc;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("cat.gencat.darp.ervc");

        noClasses()
            .that()
                .resideInAnyPackage("cat.gencat.darp.ervc.service..")
            .or()
                .resideInAnyPackage("cat.gencat.darp.ervc.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..cat.gencat.darp.ervc.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
