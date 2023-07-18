package org.luopanbi.web;

import org.luopanbi.business.dataset.DatasetBizService;
import org.luopanbi.common.web.PageParam;
import org.luopanbi.common.web.PageResult;
import org.luopanbi.common.web.R;
import org.luopanbi.web.vo.AddDatasetReq;
import org.luopanbi.web.vo.DatasetVO;
import org.luopanbi.web.vo.EditDatasetReq;
import org.luopanbi.web.vo.EditDatasourceReq;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/dataset/v1")
public class DatasetController {

    private final DatasetBizService datasetBizService;

    public DatasetController(DatasetBizService datasetBizService) {
        this.datasetBizService = datasetBizService;
    }

    @GetMapping("/list")
    public R<PageResult<DatasetVO>> listAll(PageParam pageParam) {
        return R.ok(datasetBizService.listAll(pageParam));
    }

    @GetMapping("/{id}")
    public R<DatasetVO> getById(@PathVariable("id") Integer id) {
        return R.ok(datasetBizService.getById(id));
    }

    @PutMapping("/")
    public R<DatasetVO> addDataset(@Valid @RequestBody AddDatasetReq addDatasetReq) {
        return R.ok(datasetBizService.addDataset(addDatasetReq));
    }

    @PostMapping("/{id}")
    public R<DatasetVO> editDataset(@PathVariable("id") Integer id, @Valid @RequestBody EditDatasetReq editDatasetReq) {
        return R.ok(datasetBizService.editDataset(id, editDatasetReq));
    }


}
