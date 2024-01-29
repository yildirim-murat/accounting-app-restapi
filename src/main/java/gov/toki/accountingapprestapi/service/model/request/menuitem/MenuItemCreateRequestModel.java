package gov.toki.accountingapprestapi.service.model.request.menuitem;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemCreateRequestModel implements RequestModel {

    @NotNull(message = MsgCode.VALIDATION_MENU_ITEM_NAME_NOT_NULL)
    @Size(min = Validation.MenuItem.MIN_LEN_NAME, max = Validation.MenuItem.MAX_LEN_NAME, message = MsgCode.VALIDATION_MENU_ITEM_NAME_SIZE)
    private String name;

    @Min(value = Validation.MenuItem.MIN_VAL_CALORIES, message = MsgCode.VALIDATION_MENU_ITEM_CALORIES_MIN)
    private Integer calories;

}
