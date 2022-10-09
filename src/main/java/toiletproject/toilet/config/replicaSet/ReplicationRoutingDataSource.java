package toiletproject.toilet.config.replicaSet;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    private CustomDataSourceProperties dataSource;
    public ReplicationRoutingDataSource(CustomDataSourceProperties dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 현재 요청에서 사용할 DataSource 결정할 key값 반환
     */
    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        if (isReadOnly) {
            log.info("Connection Slave");
            return dataSource.getSlave();
        } else {
            log.info("Connection Master");
            return "master";
        }
    }
}