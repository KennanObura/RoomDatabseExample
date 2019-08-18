package video.nts.nl.componentarch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "word_table")
data class Word (

    @NotNull
    @ColumnInfo(name = "word")
    var mWord: String? = null,

    @PrimaryKey(autoGenerate = true)
    @NotNull
    var id: Int = 0
)